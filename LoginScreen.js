import React, { useState } from 'react';
import { View, TextInput, Button, StyleSheet } from 'react-native';

function LoginScreen({ navigation }) {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const handleLogin = () => {
        navigation.reset({
        index: 0,
        routes: [{ name: 'Home' }],
        });
    };

    return (
        <View style={styles.container}>
            <TextInput 
                placeholder="Nom d'utilisateur" 
                value={username} 
                onChangeText={setUsername} 
                style={styles.input}
            />
            <TextInput 
                placeholder="Mot de passe" 
                value={password} 
                onChangeText={setPassword} 
                secureTextEntry
                style={styles.input}
            />
            <Button title="Connexion" onPress={handleLogin} />
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        paddingHorizontal: 15,
    },
    input: {
        height: 40,
        borderColor: 'gray',
        borderWidth: 1,
        marginBottom: 10,
        padding: 10,
    },
});

export default LoginScreen;