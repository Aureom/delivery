import './styles.css'
import StepsHeader from "./StepsHeader";
import ProductsList from "./ProductsList";
import {useEffect, useState} from "react";
import {OrderLocationData, Product} from "./types";
import {fetchProducts, saveOrder} from "../../api";
import OrderLocation from "./OrderLocation";
import OrderSummary from "./OrderSummary";
import {checkIsSelect} from "./helpers";
import {toast} from "react-toastify";

function Orders() {
    const [products, setProducts] = useState<Product[]>([])
    const [selectedProducts, setSelectedProducts] = useState<Product[]>([])
    const [orderLocation, setOrderLocation] = useState<OrderLocationData>()
    const totalPrice = selectedProducts.reduce((sum, item) => {
        return sum + item.price;
    }, 0)

    useEffect(() => {
        fetchProducts()
            .then(response => setProducts(response.data))
            .catch(error => toast("Ocorreu um erro ao carregar os produtos " + error.id))
    }, [])

    const handleSelectProduct = (product: Product) => {
        const isAlreadySelected = checkIsSelect(selectedProducts, product);

        if (isAlreadySelected) {
            const selected = selectedProducts.filter(item => item.id !== product.id);
            setSelectedProducts(selected);
        } else {
            setSelectedProducts(previous => [...previous, product]);
        }
    }

    const handleSubmit = () => {
        const productsIds = selectedProducts.map(({ id }) => ({ id }));
        const payload = {
            ...orderLocation!,
            products: productsIds
        }

        saveOrder(payload).then((respose) => {
                toast(`Pedido enviado Nº ${respose.data.id}`);
                setSelectedProducts([]);
            })
            .catch(() => {
                toast('Erro ao enviar pedido');
            })
    }

    return (
        <div className="orders-container">
            <StepsHeader/>
            <ProductsList
                products={products}
                onSelectProduct={handleSelectProduct}
                selectedProducts={selectedProducts}
            />
            <OrderLocation
                onChangeLocation={location => setOrderLocation(location)}
            />
            <OrderSummary
                amount={selectedProducts.length}
                totalPrice={totalPrice}
                onSubmit={handleSubmit}
            />
        </div>
    );
}

export default Orders;