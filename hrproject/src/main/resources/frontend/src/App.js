import React, {useState, useEffect} from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import axios from 'axios';

const UserProfiles = () => {

    const [userProfiles,setUserProfiles] = useState([]);
    const fetchUserProfiles =  () => {
      axios.get("http://localhost:8083/getAll").then(res => {
        console.log(res);
        setUserProfiles(res.data);
      });
    }

    useEffect(() =>{
      fetchUserProfiles();
    }, []);

    return userProfiles.map((UserProfile, index) => {
      return (
      
              <tbody>
                <tr>
                  <td>{UserProfile[0]}</td>
                  <td>{UserProfile[1]}</td>   
                </tr>
              </tbody>
           
      )
    })
};


function App() {
  return (

    <div className="App">
      <div className="container">
          <table className="table">
              <thead>
                <tr>
                  <th scope="col">First</th>
                  <th scope="col">Last</th>
                </tr>
              </thead>
              <UserProfiles />
              </table>
        </div>
      </div>
  );
}

export default App;
