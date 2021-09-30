import React from 'react';
import { Link } from 'react-router-dom';
import Rating from './Rating';

export default function Product(props) {
  const { product} = props;
  
  return (
    <div key={product._id} className="card">
      <Link to={`/product/${product._id}`}>
        <img className="medium" src={product.images} alt={product.name} />
        </Link>
      <div className="card-body">
      <Link to={`/product/${product._id}`}>
          <h2>{product.name}</h2>
          </Link>
          
          <h2 className="h2Home">Category:{product.category}</h2>
        <Rating
          rating={product.rating}
          numReviews={product.numReviews}
        ></Rating>
        <div className="price">₹{product.price}</div>
      </div>
    </div>
  );
}
