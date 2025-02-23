import java.util.ArrayList;
import java.util.Scanner;

class PetShop {
    private static class Product {
        private int id;
        private String name;
        private String category;
        private double price;

        public Product(int id, String name, String category, double price) {
            this.id = id;
            this.name = name;
            this.category = category;
            this.price = price;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getCategory() {
            return category;
        }

        public double getPrice() {
            return price;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Nama: " + name + ", Kategori: " + category + ", Harga: " + price;
        }
    }

    private ArrayList<Product> products = new ArrayList<>();
    private int nomor = 1;

    public void addProduct(String name, String category, double price) {
        products.add(new Product(nomor++, name, category, price));
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Tidak ada produk dalam daftar.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public void updateProduct(int id, String newName, String newCategory, double newPrice) {
        for (Product product : products) {
            if (product.getId() == id) {
                product.setName(newName);
                product.setCategory(newCategory);
                product.setPrice(newPrice);
                System.out.println("Produk berhasil diperbarui.");
                return;
            }
        }
    }

    public void deleteProduct(int id) {
        boolean removed = products.removeIf(product -> product.getId() == id);
        if (removed) {
            System.out.println("Produk berhasil dihapus.");
        } else {
            System.out.println("Produk dengan ID " + id + " tidak ditemukan.");
        }
    }

    public void searchProduct(String name) {
        boolean found = false;
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.println(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Produk tidak ditemukan.");
        }
    }

    public static void main(String[] args) {
        PetShop shop = new PetShop();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tampilkan Produk");
            System.out.println("2. Tambah Produk");
            System.out.println("3. Ubah Produk");
            System.out.println("4. Hapus Produk");
            System.out.println("5. Cari Produk");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    shop.displayProducts();
                    break;
                case 2:
                    System.out.print("Nama Produk: ");
                    String name = scanner.nextLine();
                    System.out.print("Kategori Produk: ");
                    String category = scanner.nextLine();
                    System.out.print("Harga Produk: ");
                    double price = scanner.nextDouble();
                    shop.addProduct(name, category, price);
                    break;
                case 3:
                    System.out.print("Masukkan ID Produk yang akan diubah: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    boolean exists = false;
                    for (Product product : shop.products) {
                        if (product.getId() == updateId) {
                            exists = true;
                            break;
                        }
                    }

                    if (!exists) {
                        System.out.println("Produk dengan ID " + updateId + " tidak ditemukan.");
                        break;
                    }

                    System.out.print("Nama Baru: ");
                    String newName = scanner.nextLine();
                    System.out.print("Kategori Baru: ");
                    String newCategory = scanner.nextLine();
                    System.out.print("Harga Baru: ");
                    double newPrice = scanner.nextDouble();
                    shop.updateProduct(updateId, newName, newCategory, newPrice);
                    break;
                case 4:
                    System.out.print("Masukkan ID Produk yang akan dihapus: ");
                    int deleteId = scanner.nextInt();
                    shop.deleteProduct(deleteId);
                    break;
                case 5:
                    System.out.print("Masukkan Nama Produk yang dicari: ");
                    String searchName = scanner.nextLine();
                    shop.searchProduct(searchName);
                    break;
                case 6:
                    System.out.println("Keluar dari program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }
}
