import React from 'react';
import { View, Text, Image, StyleSheet } from 'react-native';

function OrderConfirmation() {
    return (
        <View style={styles.container}>
            <Image source={require('./assets/images/commande.png')} style={styles.image} />
            <Text style={styles.text}>Félicitation! Votre commande est en route 🏍️</Text>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#FFFFFFF'
    },
    text: {
        marginTop: 20,
        fontSize: 18,
        textAlign: 'center'
    },
    image: {
        width: 200, 
        height: 200,
    }
});

export default OrderConfirmation;
