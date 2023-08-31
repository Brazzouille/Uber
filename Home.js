import React, { useState } from 'react';
import { ScrollView } from 'react-native';
import plats from './Data';  
import Plat from './Plat';
import PlatDetails from './PlatDetails';

function Home({ navigation }) {
    const [selectedPlats, setSelectedPlats] = useState([]);
    const [selectedPlatDetails, setSelectedPlatDetails] = useState(null);

    const handleSelect = (id) => {
        setSelectedPlats(prev => [...prev, id]);
    };

    const handleDetails = (plat) => {
        setSelectedPlatDetails(plat);
    };

    return (
        <ScrollView style={{ flex: 1, padding: 10 }}>
            {plats.map(plat => (
                <Plat key={plat.id} plat={plat} onSelect={handleSelect} onDetails={handleDetails} />
            ))}
            {selectedPlatDetails && <PlatDetails plat={selectedPlatDetails} />}
        </ScrollView>
    );
}

export default Home;
