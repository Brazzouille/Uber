import pizzaImage from './assets/images/pizza.jpg';
import patesImage from './assets/images/pates.jpg';

const plats = [
    {
        id: 1,
        name: "Pizza",
        image: pizzaImage,
        ingredients: ["Sauce tomate", "Fromage"],
        allergenes: ["gluten"],
        price: 15.99,
        category: "végétarien"
    },
    {
        id: 2,
        name: "Pates",
        image: patesImage,
        ingredients: ["Sauce tomate", "Basilic"],
        allergenes: ["gluten"],
        price: 11.99,
        category: "végétarien"
    },
];

export default plats;
