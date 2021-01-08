export type Product = {
    key: number;
    id: number;
    name: string;
    price: number;
    description: string;
    imageUri: string;
}

export type orderLocationData = {
    latitude: number,
    longitude: number,
    address: string
}