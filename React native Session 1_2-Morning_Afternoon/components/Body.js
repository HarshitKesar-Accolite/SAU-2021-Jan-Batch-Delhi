import React, { useEffect, useState } from "react";
import {
  ActivityIndicator,
  FlatList,
  StyleSheet,
  View,
  Text,
  TouchableOpacity,
} from "react-native";
import ListItem from "./ListItem";

const movieURL =
  "https://api.themoviedb.org/3/discover/movie?api_key=0bb8ee577f0a7e65149ee647a2a2c689&page=";

const Body = () => {
  const [isLoading, setIsLoading] = useState(false);
  const [data, setData] = useState([]);
  const [pgNo, setPgNo] = useState(1);

  useEffect(() => {
    setIsLoading(true);
    fetch(`${movieURL}${pgNo}`)
      .then((response) => response.json())
      .then((json) => {
        setData(json.results);
        setPgNo(pgNo + 1);
      })
      .catch((error) => alert(error))
      .finally(setIsLoading(false));
  }, []);

  const fetchMore = () => {
    setIsLoading(true);
    setPgNo(pgNo + 1);
    fetch(`${movieURL}${pgNo}`)
      .then((response) => response.json())
      .then((json) => {
        setData((prev) => [...prev, ...json.results]);
      })
      .catch((error) => alert(error))
      .finally(setIsLoading(false));
  };

  return (
    <View>
      {isLoading ? (
        <ActivityIndicator size={"large"} />
      ) : (
        <FlatList
          data={data}
          keyExtractor={({ id }, index) => id}
          renderItem={({ item }) => <ListItem item={item} />}
          onEndReached={() => fetchMore()}
        />
      )}
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
  },
});

export default Body;
