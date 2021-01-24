import React from "react";
import {
  FlatList,
  StyleSheet,
  View,
  Text,
  TouchableOpacity,
  Image,
  ImagePropTypes,
  ImageBackground,
  Button,
} from "react-native";

const imgUrl = "https://image.tmdb.org/t/p/original";

const ListItem = ({ item }) => {
  return (
    <View>
      <View style={styles.container}>
        <TouchableOpacity>
          <Image
            source={{ uri: `${imgUrl}${item.backdrop_path}` }}
            style={{ height: 280, width: 380, borderRadius: 10 }}
          />
        </TouchableOpacity>
        <Text style={styles.title}>{item.title}</Text>
        <View style={styles.shortInfo}>
          <View style={{ marginLeft: 5 }}>
            <Text style={styles.info}>Release Date : {item.release_date}</Text>
            <Text style={styles.info}>Ratings : {item.vote_average}</Text>
          </View>
          <View>
            <Button
              onPress={() => setSearchText("")}
              title="View Details"
            ></Button>
          </View>
        </View>
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    height: 380,
    width: 380,
    flex: 1,
    backgroundColor: "#fff",
    marginBottom: 10,
    justifyContent: "center",
    borderStyle: "solid",
    borderColor: "black",
    borderBottomWidth: 3,
  },
  title: {
    textAlign: "center",
    fontSize: 18,
    fontWeight: "bold",
    marginVertical: 5,
  },
  info: {
    fontWeight: "bold",
  },
  shortInfo: {
    flexDirection: "row",
    justifyContent: "space-between",
  },
});

export default ListItem;
