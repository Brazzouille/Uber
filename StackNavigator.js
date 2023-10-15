import React from 'react';
import { createStackNavigator } from '@react-navigation/stack';
import Home from './Home'; 
import CartScreen from './CartScreen';
import PlatDetails from './PlatDetails';
import CartIcon from './CartIcon';
import LoginScreen from './LoginScreen';  // Ajoutez cette ligne

const Stack = createStackNavigator();

function StackNavigator() {
    return (
        <Stack.Navigator initialRouteName="Login">  
            <Stack.Screen 
                name="Login" 
                component={LoginScreen} 
                options={{ title: 'Connexion' }}
            />
            <Stack.Screen 
                name="Home" 
                component={Home} 
                options={{ 
                    title: 'DeliveCrous', 
                    headerRight: () => <CartIcon />,
                    headerLeft: null 
                }}
            />
            <Stack.Screen 
                name="Cart" 
                component={CartScreen} 
                options={{ title: 'Panier' }}
            />
            <Stack.Screen 
                name="PlatDetails" 
                component={PlatDetails} 
                options={{ title: 'Détails du plat' }}
            />
        </Stack.Navigator>
    );
}

export default StackNavigator;
