import React, { useContext } from 'react';
import { View, Image, Text, StyleSheet, Button } from 'react-native';
import { CartContext } from './CartContext'; 

const PlatDetails = ({ route }) => {
    const { plat } = route.params;
    const { cart, setCart } = useContext(CartContext);

    const addToCart = (selectedPlat) => {
        const existingItem = cart.find(item => item.plat.id === selectedPlat.id);
        if (existingItem) {
            setCart(prevCart => prevCart.map(item =>
                item.plat.id === selectedPlat.id
                    ? { ...item, quantity: item.quantity + 1 }
                    : item
            ));
        } else {
            const cartItem = {
                id: `${selectedPlat.id}-${Date.now()}`, 
                plat: selectedPlat,
                quantity: 1
            };
            setCart(prevCart => [...prevCart, cartItem]);
        }
    };

    return (
        <View style={styles.container}>
            <Image source={plat.image} style={{ width: 390, height: 170 }} />
            <Text style={styles.mainTitle}>{plat.name}</Text>
            <Text style={styles.ingredients}>{plat.ingredients.join(', ')}</Text>
            <Text style={styles.allergens}>Allergènes: {plat.allergenes.join(', ')}</Text>
            <Text style={styles.price}>{plat.price}€</Text>
            <Button title="Ajouter au panier" onPress={() => addToCart(plat)} />
        </View>
    );
};


const styles = StyleSheet.create({
    container: {
        flexDirection: 'column',
        padding: 10,
        alignItems: 'center',
    },
    mainTitle: {
        fontSize: 36,
        fontWeight: '400',
        color: 'black',
        marginTop: 10,
    },
    ingredients: {
        fontSize: 13,
        fontWeight: '400',
        color: 'black',
        marginTop: 10,
    },
    allergens: {
        fontSize: 20,
        fontWeight: '400',
        color: 'black',
        marginTop: 10,
    },
    price: {
        fontSize: 20,
        fontWeight: 'bold',
        color: 'black',
        marginTop: 10,
    },
});

export default PlatDetails;
