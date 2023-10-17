import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import StackNavigator from './StackNavigator';
import { CartProvider } from './CartContext';  

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
