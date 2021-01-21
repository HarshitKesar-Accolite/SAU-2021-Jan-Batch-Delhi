import React from "react";
import PropTypes from "prop-types";

class Todolist extends React.Component {
  static propTypes = {
    todos: PropTypes.arrayOf(
      PropTypes.shape({
        todo: PropTypes.string,
        marked: PropTypes.bool,
      })
    ),
  };

  render() {
    const {todos, markTaskAsCompleted,  createDuplicateTask, deleteTask} = this.props;

    return (
      <div className="todoList">
        <h2>
          {this.props.title}
        </h2>
        <ul style={{ listStyle: "none", padding: 0, margin: 0 }}>
          {todos
            ? todos.map((value, index) => {
                return (
                  <li key={index} className="TaskRow">
                    <label
                      style={
                        value.marked
                          ? {
                              textDecoration: "line-through",
                            }
                          : {}
                      }
                    >
                      <input
                        type="checkbox"
                        checked={value.marked}
                        onChange={(event) => markTaskAsCompleted(value.id)}
                      />
                      {value.todo}
                    </label>
                    <button
                      className="hidden"
                      onClick={(event) => deleteTask(value.id)}
                    >
                      Delete
                    </button>
                    <button
                      className="hidden"
                      onClick={(event) => createDuplicateTask(value.id)}
                    >
                      Duplicate
                    </button>
                  </li>
                );
              })
            : null}
        </ul>
      </div>
    );
  }
}

export default Todolist;
