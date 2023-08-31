import React from 'react';
import { View, Image, Text } from 'react-native';

const PlatDetails = ({ route }) => {
    const { plat } = route.params;

    return (
        <View style={{ flexDirection: 'column', padding: 10, alignItems: 'center' }}>
            <Image source={plat.image} style={{ width: 390, height: 170 }} />
            <Text style={{ marginTop: 10 }}>{plat.ingredients.join(', ')}</Text>
            <Text style={{ marginTop: 10 }}>Allergènes: {plat.allergenes.join(', ')}</Text>
            <Text style={{ marginTop: 10, fontWeight: 'bold' }}>{plat.price}€</Text>
        </View>
    );
};

export default PlatDetails;
