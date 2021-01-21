import React from "react";
import TodoInput from "./TodoInput";
import "./styles.css";
import Todolist from "./TodoList";

class Todo extends React.Component {
  state = {
    id: 1,
    todo: "",
    todos: [],
    title: "All Tasks :",
    filterBy: "showAll",
  };

  handleOnChange = (event) => {
    this.setState({ todo: event.target.value });
  };

  addTask = () => {
    const { id, todo, todos } = this.state;
    const newTodos = [...todos];

    if (todo !== "") {
      newTodos.push({ todo: todo, marked: false, delete: false, id:id });
      this.setState({ todos: newTodos, todo: "", id:id+1 });
    }
    console.log(newTodos);
  };

  markTaskAsCompleted = (id) => {
    //console.log(id);
    const { todos } = this.state;
    const newTodos = [];
    var updatedTodo = {};
    todos.forEach(element => {
      if(element.id === id){
        //console.log(id);
        updatedTodo = {
          ...element,
          marked: !element.marked
        };
        newTodos.push(updatedTodo);
      }
      else{
        newTodos.push(element);
      }
    });
    this.setState({todos: newTodos});
    //console.log(newTodos);
  };

  createDuplicateTask = (id) => {
    //console.log(id);
    const { todos } = this.state;
    const newTodos = [];
    var newTodo = {};
    todos.forEach(element => {
      if(element.id === id){
        //console.log(id);
        newTodo = {
          ...element,
          id: this.state.id,
          marked: false
        };
      }
      newTodos.push(element);
    });
    newTodos.push(newTodo);
    this.setState({todos: newTodos, id:this.state.id+1});
    //console.log(newTodos);
  };

  deleteTask = (id) => {
    //console.log(id);
    const { todos } = this.state;
    const newTodos = [];
    todos.forEach(element => {
      if(element.id === id){
        //console.log("Do Nothing : " + id);
      }
      else{
        newTodos.push(element);
      }
    });
    this.setState({todos: newTodos});
    //console.log(newTodos);
  };

  setShowAll = () => {
    const { filterBy } = this.state;
    const newFilterBy = "showAll";
    const newTitle = "All Tasks :";
    
    if (filterBy !== newFilterBy) {
      this.setState({ filterBy: newFilterBy, title: newTitle });
    }
  };
  
  setCompleted = () => {
    const { filterBy } = this.state;
    const newFilterBy = "completed";
    const newTitle = "Completed Tasks :";
  
    if (filterBy !== newFilterBy) {
      this.setState({ filterBy: newFilterBy, title: newTitle });
    }
  };
  
  setPending = () => {
    const { filterBy } = this.state;
    const newFilterBy = "pending";
    const newTitle = "Pending Tasks :";
  
    if (filterBy !== newFilterBy) {
      this.setState({ filterBy: newFilterBy, title: newTitle });
    }
  };
  
  render() {

    var todos = []
    if(this.state.filterBy === "showAll"){
      todos = [...this.state.todos]
    }
    if(this.state.filterBy === "pending"){
      todos = this.state.todos.filter((item) =>{
        if(item.marked === false){
          return true;
        }
        return false;
      })
    }
    if(this.state.filterBy === "completed"){
      todos = this.state.todos.filter((item) =>{
        if(item.marked === true){
          return true;
        }
        return false;
      })
    }

    return (
      <div className="TodoContainer">
        <h1 className="Header Header-Main">{this.props.title}</h1>
        <TodoInput
          taskPlaceholder="Add new Task"
          value={this.state.todo}
          onChange={this.handleOnChange}
        />
        <button style={{margin: 15}} onClick={this.addTask}>Add Task</button><br></br>
        <button onClick={this.setShowAll}>All Tasks</button>
        <button style={{margin: 2}} onClick={this.setCompleted}>Completed Tasks</button>
        <button onClick={this.setPending}>Pending Tasks</button>
        <Todolist
          title={this.state.title}
          todos={todos}
          markTaskAsCompleted={this.markTaskAsCompleted}
          createDuplicateTask={this.createDuplicateTask}
          deleteTask={this.deleteTask}
        />
      </div>
    );
  }
}

export default Todo;
