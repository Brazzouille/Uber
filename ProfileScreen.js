import React from 'react';
import { View, Text, StyleSheet, Image } from 'react-native';

function ProfileScreen({ route }) {
    const { userId = 'Aucun identifiant fourni', password = '' } = route.params || {};

    const censorPassword = (password) => {
        return '*'.repeat(password.length);
    };

    return (
        <View style={styles.container}>
            <Image 
                source={require('./assets/images/avatar.png')} 
                style={styles.avatar}
            />
            <Text>Identifiant: {userId}</Text>
            <Text>Mot de passe: {censorPassword(password)}</Text>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center',
    },
    avatar: {
        width: 100,
        height: 100,
        borderRadius: 50, 
        marginBottom: 20,
    },
});

export default ProfileScreen;
