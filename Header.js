// Header.js
import React from 'react';
import { View, Text, TouchableOpacity, StyleSheet } from 'react-native';
import { useNavigation } from '@react-navigation/native';

const Header = ({ title, onCartPress }) => {
    const navigation = useNavigation();

    return (
        <View style={styles.header}>
            <Text style={styles.title}>{title}</Text>
            <TouchableOpacity onPress={onCartPress}>
                <Text style={styles.cart}>🛒</Text>  {/* emoji de caddie */}
            </TouchableOpacity>
        </View>
    );
};

const styles = StyleSheet.create({
    header: {
        flexDirection: 'row',
        justifyContent: 'space-between',
        alignItems: 'center',
        padding: 10,
        backgroundColor: '#eee',
    },
    title: {
        fontSize: 24,
    },
    cart: {
        fontSize: 24,
    }
});

export default Header;
