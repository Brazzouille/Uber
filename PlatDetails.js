import React from 'react';
import { View, Image, Text } from 'react-native';

const PlatDetails = ({ plat }) => (
    <View style={{ flexDirection: 'column', padding: 10, alignItems: 'center' }}>
        
        <Image source={{ uri: plat.image }} style={{ width: 200, height: 200 }} />

        <Text style={{ marginTop: 10 }}>{plat.ingredients.join(', ')}</Text>

        <Text style={{ marginTop: 10 }}>Allergènes: {plat.allergenes.join(', ')}</Text>

        <Text style={{ marginTop: 10, fontWeight: 'bold' }}>{plat.price}€</Text>
    </View>
);

export default PlatDetails;
