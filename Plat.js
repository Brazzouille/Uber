import React from 'react';
import { View, Image, Text, TouchableOpacity } from 'react-native';

const Plat = ({ plat, onSelect, onDetails, navigation }) => (
    <View style={{ flexDirection: 'column', margin: 10 }}>
        
        <TouchableOpacity onPress={() => {
            onDetails(plat);
            navigation.navigate('PlatDetails', { plat: plat });
        }}>
            <Image source={plat.image} style={{ width: 100, height: 100 }} />
        </TouchableOpacity>
        
        <Text>{plat.ingredients.join(', ')}</Text>
        <Text>{plat.price}€</Text>
    </View>
);

export default Plat;
