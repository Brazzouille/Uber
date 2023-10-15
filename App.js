import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import StackNavigator from './StackNavigator';
import { CartProvider } from './CartContext';  // Assurez-vous que le chemin d'importation est correct

function App() {
    return (
        <NavigationContainer>
            <CartProvider>
                <StackNavigator />
            </CartProvider>
        </NavigationContainer>
    );
}

export default App;
