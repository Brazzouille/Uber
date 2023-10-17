import React, { useContext } from 'react';
import { Button, View, Text, StyleSheet } from 'react-native';
import { useNavigation } from '@react-navigation/native';
import { CartContext } from './CartContext'; 

function CartIcon() {
    const navigation = useNavigation();
    const { cart } = useContext(CartContext);
    const cartItemCount = cart.reduce((total, item) => total + item.quantity, 0);

    return (
        <View style={styles.container}>
            <Button 
                title="🛒"
                onPress={() => navigation.navigate('Cart')}
            />
            {cartItemCount > 0 && (
                <View style={styles.badgeContainer}>
                    <Text style={styles.badgeText}>{cartItemCount}</Text>
                </View>
            )}
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flexDirection: 'row',
        alignItems: 'center',
    },
    badgeContainer: {
        position: 'absolute',
        left: -10, 
        top: -10,
        backgroundColor: 'red',
        borderRadius: 10,
        width: 17,
        height: 17,
        justifyContent: 'center',
        alignItems: 'center',
    },
    badgeText: {
        color: 'white',
        fontWeight: 'bold',
    },
});

export default CartIcon;
