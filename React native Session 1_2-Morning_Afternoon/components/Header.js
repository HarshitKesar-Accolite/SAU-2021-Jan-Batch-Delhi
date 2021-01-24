import { StatusBar } from "expo-status-bar";
import React, { useState } from "react";
import { render } from "react-dom";
import { Button, StyleSheet, TextInput, View } from "react-native";

export default function Header() {
  const [searchText, setSearchText] = useState("");
  const sortByYear = () => {};
  return (
    <View style={styles.header}>
      <View style={styles.headerTextBox}>
        <TextInput
          value={searchText}
          placeholder="Search"
          onChangeText={(value) => setSearchText(value)}
        ></TextInput>
      </View>
      <View style={styles.headerButtons}>
        <View style={styles.btnClear}>
          <Button onPress={() => setSearchText("")} title="X"></Button>
        </View>
        <View>
          <Button onPress={sortByYear} title="S"></Button>
        </View>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  header: {
    marginTop: 160,
    flexDirection: "row",
    padding: 8,
    backgroundColor: "#C0C0C0",
    margin: 20,
  },
  headerTextBox: {
    width: 250,
    height: 40,
  },
  headerButtons: {
    flexDirection: "row",
  },
  btnClear: {
    marginHorizontal: 20,
  },
});
