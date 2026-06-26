## SIMRS
Tujuan proyek ini adalah untuk belajar mengimplementasikan Java Module, JavaFX dan Maven serta fitur Java lainnya dari aplikasi yang sudah ada. Untuk mencapai hal tersebut, akan dilakukan __refactoring__.

Aplikasi yang di***fork*** merupakan Software Manajemen Rumah Sakit/Klinik/Puskesmas SIMRS-Khanza https://github.com/mas-elkhanza SIMRS-Khanza. Selain gratis dan sumber tersedia, boleh juga digunakan siapa saja tanpa dikenai biaya apapun. Namun, dilarang untuk memperjualbelikan atau mengambil keuntungan dalam bentuk apapun tanpa seijin pembuat software (Khanza.Soft Media).  Licensi yang dianutnya adalah https://en.wikipedia.org/wiki/Aladdin_Free_Public_License.

### Persyaratan

- JDK 25
- Maven 3.9+
- Podman 5.8+
- MariaDB 11.1

### Instalasi Aplikasi

#### clone

```bash
git clone https://github.com/mohamad-salman/simrs.git
cd simrs
```

### Instalasi Database

#### Membuat Volume

```bash
podman volume create simrs-db
```

#### Download Image

```bash
podman pull docker.io/mariadb:11.1
```

#### Menjalankan Database

```bash
podman run -d \
  --name mariadb-simrs \
  -p 3306:3306 \
  -e MARIADB_ROOT_PASSWORD=secret \
  -e MARIADB_DATABASE=sik \
  -v simrs-db:/var/lib/mysql:Z \
  mariadb:11.1
```

#### Restore Database

```bash
podman exec -i mariadb-simrs mariadb -u root -psecret sik < sik.sql
```

### Menjalankan Aplikasi

#### Instalasi library

```bash
chmod +x install-libs.sh
./install-libs.sh
```

#### Eksekusi

```bash
chmod +x run.sh
./run.sh
```

