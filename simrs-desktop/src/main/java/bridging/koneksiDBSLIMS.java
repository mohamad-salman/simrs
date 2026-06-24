package bridging;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;
import javax.swing.JOptionPane;
import ms.simrs.kripto.EnkripsiAES;

/**
 *
 * @author khanzasoft
 */
public class koneksiDBSLIMS {
    private static Connection connection=null;
    private static final Properties prop = new Properties();  
    private static final MysqlDataSource dataSource=new MysqlDataSource();
    
    public koneksiDBSLIMS(){} 
    public static Connection condb(){ 
        if(connection == null){
            try{
                prop.loadFromXML(new FileInputStream("setting/database.xml"));
                dataSource.setURL("jdbc:mysql://"+EnkripsiAES.decrypt(prop.getProperty("HOSTSLIMS"))+":"+EnkripsiAES.decrypt(prop.getProperty("PORTSLIMS"))+"/"+EnkripsiAES.decrypt(prop.getProperty("DATABASESLIMS"))+"?zeroDateTimeBehavior=convertToNull&autoReconnect=true&useCompression=true");
                dataSource.setUser(EnkripsiAES.decrypt(prop.getProperty("USERSLIMS")));
                dataSource.setPassword(EnkripsiAES.decrypt(prop.getProperty("PASSLIMS")));
                dataSource.setCachePreparedStatements(true);
                dataSource.setUseCompression(true);
                dataSource.setUseLocalSessionState(true);
                dataSource.setUseLocalTransactionState(true);
                connection=dataSource.getConnection();       
                System.out.println("  Koneksi Berhasil. Menyambungkan ke database bridging SLIMS...!!!");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Koneksi ke server bridging SLIMS terputus : "+e);
            }
        }
        return connection;        
    }
    
}
