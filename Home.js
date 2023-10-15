import React, { useState } from 'react';
import { ScrollView } from 'react-native';
import plats from './Data';  
import Plat from './Plat';

function Home({ navigation }) {
    const [selectedPlats, setSelectedPlats] = useState([]);
    const [selectedPlatDetails, setSelectedPlatDetails] = useState(null);

    const handleSelect = (id) => {
        setSelectedPlats(prev => [...prev, id]);
    };

    const handleDetails = (plat) => {
        setSelectedPlatDetails(plat);
        navigation.navigate('PlatDetails', { plat: plat });  
    };

    return (
        <ScrollView style={{ flex: 1, padding: 10 }}>
            {plats.map(plat => (
                <Plat 
                    key={plat.id} 
                    plat={plat} 
                    onSelect={handleSelect} 
                    onDetails={handleDetails}
                    navigation={navigation}  
                />
            ))}
            {/* Retiré car nous naviguons désormais vers une nouvelle page pour les détails 
            {selectedPlatDetails && <PlatDetails plat={selectedPlatDetails} />} 
            */}
        </ScrollView>
    );
}

export default Home;