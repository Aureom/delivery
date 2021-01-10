import ProductCard from "./ProductCard";
import {Product} from "./types";
import {checkIsSelect} from "./helpers";

type Props = {
    products: Product[];
    selectedProducts: Product[];
    onSelectProduct: (product: Product) => void;
}

function ProductsList({ products, selectedProducts, onSelectProduct }: Props) {
    return (
        <div className="orders-list-container">
            <div className="orders-list-items">
                {products.map(product => (
                    <ProductCard
                        key={product.id}
                        product={product}
                        onSelectProduct={onSelectProduct}
                        isSelected={checkIsSelect(selectedProducts, product)}
                    />
                ))}
            </div>
        </div>
    );
}

export default ProductsList;