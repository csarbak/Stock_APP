import React, { useEffect, useState } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

const StockList = () => {

  const [stocks, setStocks] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true);

    fetch('api/stocks')
      .then(response => response.json())
      .then(data => {
        setStocks(data);
        setLoading(false);
      })
  }, []);

  const remove = async (id) => {
    await fetch(`/api/stock/${id}`, {
      method: 'DELETE',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    }).then(() => {
      let updatedStocks = [...stocks].filter(i => i.id !== id);
      setStocks(updatedStocks);
    });
  }

  if (loading) {
    return <p>Loading...</p>;
  }

  const stockList = stocks.map(stock => {
    //const address = `${stock.logo || ''} ${stock.currentPrice || ''}`; //change here
    return <tr key={stock.id}>
      <td style={{whiteSpace: 'nowrap'}}>{stock.logo}</td>
            <td>{stock.currentPrice}</td>
      
      
      <td>
        <ButtonGroup>
          <Button size="sm" color="primary" tag={Link} to={"/stocks/" + stock.id}>Edit</Button>
          <Button size="sm" color="danger" onClick={() => remove(stock.id)}>Delete</Button>
        </ButtonGroup>
      </td>
    </tr>
  });

  return (
    <div>
      <AppNavbar/>
      <Container fluid>
        <div className="float-end">
          <Button color="success" tag={Link} to="/stocks/new">Add Stock</Button>
        </div>
        <h3>My JUG Tour</h3>
        <Table className="mt-4">
          <thead>
          <tr>
            <th width="20%">Name</th>
            <th width="20%">currentPrice</th>
            
            <th width="10%">Actions</th>
          </tr>
          </thead>
          <tbody>
          {stockList}
          </tbody>
        </Table>
      </Container>
    </div>
  );
};

export default StockList;