<?php
class PetShop {
    private $products = [];
    private $nomor = 1;

    public function addProduct($name, $category, $price, $image) {
        $this->products[] = [
            'id' => $this->nomor++,
            'name' => $name,
            'category' => $category,
            'price' => $price,
            'image' => $image
        ];
    }

    public function displayProducts() {
        if (empty($this->products)) {
            echo "<p>Tidak ada produk dalam daftar.</p>";
        } else {
            echo "<div style='display: flex; flex-wrap: wrap; gap: 10px;'>";
            foreach ($this->products as $product) {
                echo "
                    <div style='border: 1px solid #ccc; padding: 10px; width: 250px; text-align: center;'>
                        <img src='{$product['image']}' alt='{$product['name']}' style='width: 100%; height: 200px; object-fit: cover;'>
                        <h3>{$product['name']}</h3>
                        <p>Kategori: {$product['category']}</p>
                        <p>Harga: $" . number_format($product['price'], 0, ',', '.') . "</p>
                    </div>
                ";
            }
            echo "</div>";
        }
    }
}

// Inisialisasi PetShop
$shop = new PetShop();

// Menambahkan produk dengan gambar statis
$shop->addProduct("Wife 1", "Wife", 100000000, "New_Beginnings_T.jpg");
$shop->addProduct("Wife 1.1", "Wife", 1000000000, "To_Become_The_Idol_You_Can_Be_Proud_Of_T.jpg");

?>

<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PetShop</title>
</head>
<body>
    <h1>Daftar</h1>
    <?php $shop->displayProducts(); ?>
</body>
</html>
