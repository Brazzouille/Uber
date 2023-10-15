import React, { useState } from 'react';
import { ScrollView, View, Text, StyleSheet, TouchableOpacity } from 'react-native';
import plats from './Data';  
import Plat from './Plat';

function Home({ navigation }) {
    const [selectedCategory, setSelectedCategory] = useState("all"); 

    const filteredPlats = selectedCategory === "all"
        ? plats
        : plats.filter(plat => plat.category === selectedCategory);

    const handleDetails = (plat) => {
        navigation.navigate('PlatDetails', { plat: plat });  
    };    

    return (
        <View style={{ flex: 1, padding: 10 }}>
            <View style={styles.buttonContainer}>
                <TouchableOpacity onPress={() => setSelectedCategory("all")}>
                    <Text style={styles.textButton}>Tous</Text>
                </TouchableOpacity>
                <TouchableOpacity onPress={() => setSelectedCategory("végétarien")}>
                    <Text style={styles.textButton}>Végétarien</Text>
                </TouchableOpacity>
                <TouchableOpacity onPress={() => setSelectedCategory("vegan")}>
                    <Text style={styles.textButton}>Vegan</Text>
                </TouchableOpacity>
                <TouchableOpacity onPress={() => setSelectedCategory("sans gluten")}>
                    <Text style={styles.textButton}>Sans gluten</Text>
                </TouchableOpacity>
                <TouchableOpacity onPress={() => setSelectedCategory("halal")}>
                    <Text style={styles.textButton}>Halal</Text>
                </TouchableOpacity>
            </View>
            
            <ScrollView>
                {filteredPlats.map(plat => (
                    <Plat 
                        key={plat.id} 
                        plat={plat} 
                        navigation={navigation}  
                        onDetails={handleDetails}
                    />
                ))}
            </ScrollView>
        </View>
    );
}

const styles = StyleSheet.create({
    buttonContainer: {
        flexDirection: 'row',
        justifyContent: 'space-between',
        marginBottom: 10,
    },
    textButton: {
        marginHorizontal: 5,
        fontSize: 13,
        paddingVertical: 5,  
        paddingHorizontal: 8,  
        borderColor: '#ddd',
        borderWidth: 1,
        borderRadius: 5,
        backgroundColor: '#FFFFFF'
    }
    
});

export default Home;
