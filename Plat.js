import React from 'react';
import { View, Image, Text, TouchableOpacity } from 'react-native';
//import CheckBox from '@react-native-community/checkbox';
//<CheckBox value={false} onValueChange={() => onSelect(plat.id)} />
const Plat = ({ plat, onSelect, onDetails }) => (
    <View style={{ flexDirection: 'column', margin: 10 }}>
        
        <TouchableOpacity onPress={() => onDetails(plat)}>
            <Image source={plat.image} style={{ width: 100, height: 100 }} />
        </TouchableOpacity>
        
        <Text>{plat.ingredients.join(', ')}</Text>
        <Text>{plat.price}€</Text>
    </View>
);

export default Plat;
