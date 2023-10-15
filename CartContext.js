import React, { createContext, useState } from 'react';

export const CartContext = createContext();

export const CartProvider = ({ children }) => {
    const [cart, setCart] = useState([]);

    const addToCart = (selectedPlat) => {
        const existingItem = cart.find(item => item.plat.id === selectedPlat.id);
        if (existingItem) {
            setCart(prevCart => prevCart.map(item =>
                item.plat.id === selectedPlat.id
                    ? { ...item, quantity: item.quantity + 1 }
                    : item
            ));
        } else {
            const cartItem = {
                id: `${selectedPlat.id}-${Date.now()}`, 
                plat: selectedPlat,
                quantity: 1
            };
            setCart(prevCart => [...prevCart, cartItem]);
        }
    };

    return (
        <CartContext.Provider value={{ cart, setCart, addToCart }}>
            {children}
        </CartContext.Provider>
    );
};
