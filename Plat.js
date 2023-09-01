import React from 'react';
import { View, Image, Text, TouchableOpacity } from 'react-native';

const Plat = ({ plat, onSelect, onDetails, navigation }) => (
    <View style={{ flexDirection: 'column', margin: 10 }}>
        
        <TouchableOpacity onPress={() => {
            onDetails(plat);
            navigation.navigate('PlatDetails', { plat: plat });
        }}>
            <Image source={plat.image} style={{ width: 240, height: 160 }} />
            <Text style={{ color: 'black', fontSize: 20, fontWeight: '400' }}>
                {plat.name}
            </Text>
            <Text style={{ color: 'black', fontSize: 13, fontWeight: '400' }}>
                {plat.ingredients.join(', ')}
             </Text>
            <Text style={{ color: 'black', fontSize: 20, fontWeight: '400' }}>
                {plat.price}€
            </Text>
        </TouchableOpacity>
        

    </View>
);

export default Plat;
