import React from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import StockList from './StockList';
import StockEdit from './StockEdit';

const App = () => {
  return (
    <Router>
      <Routes>
        <Route exact path="/" element={<Home/>}/>
        <Route path='/stocks' exact={true} element={<StockList/>}/>
        <Route path='/stocks/:id' element={<StockEdit/>}/>
      </Routes>
    </Router>
  )
}

export default App;


// import React, { useEffect, useState } from 'react';
// import logo from './logo.svg';
// import './App.css';

// const App = () => {

//   const [groups, setGroups] = useState([]);
//   const [loading, setLoading] = useState(false);

//   useEffect(() => {
//     setLoading(true);

//     fetch('stock/stocks')
//       .then(response => response.json())
//       .then(data => {
//         setGroups(data);
//         setLoading(false);
//       })
//   }, []);

//   if (loading) {
//     return <p>Loading...</p>;
//   }

//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <div className="App-intro">
//           <h2>Nikki's Stock List</h2>
//           {groups.map(group =>
//             <div key={group.id}>
//               {group.logo},  current Price : {group.currentPrice}
//             </div>
//           )}
//         </div>
//       </header>
//     </div>
//   );
// }

// export default App;



// import logo from './logo.svg';
// import './App.css';

// function App() {
//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//         </p>
//         <a
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//       </header>
//     </div>
//   );
// }

//export default App;
