import React, { useContext } from 'react';
import { View, Text, Button, FlatList, Image, StyleSheet } from 'react-native';
import { CartContext } from './CartContext'; 

function CartScreen({ navigation }) {
    const { cart, setCart } = useContext(CartContext);

    const removeFromCart = (cartItemId) => {
        setCart(cart.filter(item => item.id !== cartItemId));
    };

    const decrementQuantity = (id) => {
        const item = cart.find(item => item.id === id);
        if (item.quantity > 1) {
            setCart(prevCart => prevCart.map(item =>
                item.id === id
                    ? { ...item, quantity: item.quantity - 1 }
                    : item
            ));
        } else {
            removeFromCart(id);
        }
    };

    const incrementQuantity = (id) => {
        setCart(prevCart => prevCart.map(item =>
            item.id === id
                ? { ...item, quantity: item.quantity + 1 }
                : item
        ));
    };

    const calculateTotal = () => {
        return cart.reduce((acc, item) => acc + item.plat.price * item.quantity, 0);
    };

    return (
        <View style={styles.container}>
            <FlatList 
                data={cart}
                keyExtractor={item => item.id.toString()}
                renderItem={({ item }) => (
                    <View style={styles.cartItem}>
                        <Image source={item.plat.image} style={styles.itemImage} />
                        <Text>{item.plat.name} : </Text>
                        <Text>{item.plat.price}€ x {item.quantity}</Text>
                        <Button title="-" onPress={() => decrementQuantity(item.id)} />
                        <Button title="+" onPress={() => incrementQuantity(item.id)} />
                        <Button title="Supprimer" onPress={() => removeFromCart(item.id)} />
                    </View>
                )}
            />
            <Text style={styles.total}>Total : {calculateTotal()}€</Text>
            {cart.length > 0 && (  
                <Button 
                    title="Valider le panier" 
                    onPress={() => navigation.navigate('AddressInput')}
                />
            )}
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center',
        paddingBottom: 25,  
    },
    cartItem: {
        flexDirection: 'row',
        margin: 10,
        alignItems: 'center',
    },
    itemImage: {
        width: 50,
        height: 50,
        marginRight: 10,
    },
    total: {
        fontSize: 20,
        fontWeight: 'bold',
        marginTop: 20,
    }
    
});

export default CartScreen;