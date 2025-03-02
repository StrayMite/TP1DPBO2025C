class Product:
    def __init__(self, product_id, name, category, price):
        self.product_id = product_id
        self.name = name
        self.category = category
        self.price = price

    def __str__(self):
        return f"ID: {self.product_id}, Nama: {self.name}, Kategori: {self.category}, Harga: {self.price}"

class PetShop:
    def __init__(self):
        self.products = []
        self.nomor = 1

    def add_product(self, name, category, price):
        self.products.append(Product(self.nomor, name, category, price))
        self.nomor += 1

    def display_products(self):
        if not self.products:
            print("Tidak ada produk dalam daftar.")
        else:
            for product in self.products:
                print(product)

    def update_product(self, product_id, new_name, new_category, new_price):
        for product in self.products:
            if product.product_id == product_id:
                product.name = new_name
                product.category = new_category
                product.price = new_price
                print("Produk berhasil diperbarui.")
                return
        print(f"Produk dengan ID {product_id} tidak ditemukan.")

    def delete_product(self, product_id):
        for product in self.products:
            if product.product_id == product_id:
                self.products.remove(product)
                print("Produk berhasil dihapus.")
                return

    def search_product(self, name):
        found = False
        for product in self.products:
            if product.name.lower() == name.lower():
                print(product)
                found = True
        if not found:
            print("Produk tidak ditemukan.")

def main():
    shop = PetShop()

    while True:
        print("\nMenu:")
        print("1. Tampilkan Produk")
        print("2. Tambah Produk")
        print("3. Ubah Produk")
        print("4. Hapus Produk")
        print("5. Cari Produk")
        print("6. Keluar")
        choice = input("Pilih menu: ")

        if choice == "1":
            shop.display_products()

        elif choice == "2":
            name = input("Nama Produk: ")
            category = input("Kategori Produk: ")
            price = float(input("Harga Produk: "))
            shop.add_product(name, category, price)

        elif choice == "3":
            product_id = int(input("Masukkan ID Produk yang akan diubah: "))

            exists = any(product.product_id == product_id for product in shop.products)

            if not exists:
                print(f"Produk dengan ID {product_id} tidak ditemukan.")

            else:
                new_name = input("Nama Baru: ")
                new_category = input("Kategori Baru: ")
                new_price = float(input("Harga Baru: "))
                shop.update_product(product_id, new_name, new_category, new_price)


        elif choice == "4":
            product_id = int(input("Masukkan ID Produk yang akan dihapus: "))
            shop.delete_product(product_id)

        elif choice == "5":
            search_name = input("Masukkan Nama Produk yang dicari: ")
            shop.search_product(search_name)

        elif choice == "6":
            print("Keluar dari program.")
            break
        else:
            print("Pilihan tidak valid. Coba lagi.")

if __name__ == "__main__":
    main()
