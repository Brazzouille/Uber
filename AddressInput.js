import React, { useState } from 'react';
import { View, TextInput, Button, StyleSheet } from 'react-native';

function AddressInput({ navigation }) {
    const [street, setStreet] = useState('');
    const [city, setCity] = useState('');
    const [postalCode, setPostalCode] = useState('');

    const handleSubmit = () => {
        navigation.navigate('Confirmation');
    };

    return (
        <View style={styles.container}>
            <TextInput 
                value={street}
                onChangeText={setStreet}
                placeholder="Rue"
                style={styles.input}
            />
            <TextInput 
                value={city}
                onChangeText={setCity}
                placeholder="Ville"
                style={styles.input}
            />
            <TextInput 
                value={postalCode}
                onChangeText={setPostalCode}
                placeholder="Code Postal"
                style={styles.input}
            />
            <Button title="Valider la commande" onPress={handleSubmit} />
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        padding: 10,
        flex: 1,
        justifyContent: 'center'
    },
    input: {
        borderColor: '#ccc',
        borderWidth: 1,
        padding: 10,
        marginBottom: 10,
    },
});

export default AddressInput;
