import React from "react";
import { useSelector } from "react-redux";
import { Link } from "react-router-dom";


function FinalScreen(){
    const userSignin = useSelector((state) => state.userSignin);
  const { userInfo, loading, error } = userSignin;
   return(
    <>
       <h1 className="myHeader">Congratulations!!! {userInfo?userInfo.name:"user"} </h1><h1 className="myHeader">Your Order Placed Succesfully</h1>
       <div className="homeLink">
       <Link className="brand1" to="/">
            back to shopping
            </Link>
            </div>
    </>
   ); 
}

export default FinalScreen;