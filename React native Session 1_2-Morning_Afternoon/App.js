import React, { useState } from "react";
import { StyleSheet, View } from "react-native";
import Header from "./components/Header";
import Body from "./components/Body";

const App = () => {
  return (
    <View style={styles.container}>
      <Header />
      <Body />
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

export default App;
