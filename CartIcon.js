import React from 'react';
import { Button } from 'react-native';
import { useNavigation } from '@react-navigation/native';


function CartIcon() {
    const navigation = useNavigation();

    return (
        <Button 
            title="🛒"
            onPress={() => navigation.navigate('Cart')}
        />
    );
}


export default CartIcon;
