import React from 'react';
import { createStackNavigator } from '@react-navigation/stack';
import Home from './Home'; 
import CartScreen from './CartScreen';
import PlatDetails from './PlatDetails';
import CartIcon from './CartIcon';
import LoginScreen from './LoginScreen';  
import ProfileScreen from './ProfileScreen';
import AddressInput from './AddressInput';  // Assurez-vous d'avoir ce fichier
import OrderConfirmation from './OrderConfirmation';  // Assurez-vous d'avoir ce fichier
import { Button } from 'react-native';

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
                options={({ route, navigation }) => ({
                    title: 'DeliveCrous', 
                    headerRight: () => <CartIcon />,
                    headerLeft: () => (
                        <Button 
                            title="👤" 
                            onPress={() => navigation.navigate('Profile', {
                                userId: route.params?.userId || 'VotreIdentifiant',
                                password: route.params?.password || 'VotreMotDePasse',
                            })}
                        />
                    ),
                })}
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
            <Stack.Screen 
                name="Profile" 
                component={ProfileScreen} 
                options={{ title: 'Profil' }}
            />
            <Stack.Screen 
                name="AddressInput" 
                component={AddressInput} 
                options={{ title: 'Adresse de livraison' }}
            />
            <Stack.Screen 
                name="Confirmation" 
                component={OrderConfirmation} 
                options={{ title: 'Confirmation de commande' }}
            />
        </Stack.Navigator>
    );
}

export default StackNavigator;
