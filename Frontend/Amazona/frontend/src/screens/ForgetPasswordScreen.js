import React, { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { forgetPassword } from '../actions/userActions';
import LoadingBox from '../components/LoadingBox';
import MessageBox from '../components/MessageBox';

export default function ForgetPasswordScreen(props) {
  
  const [mobileNumber,setMobileNumber] = useState('');
  const [password, setPassword] = useState('');


  const redirect = props.location.search
    ? props.location.search.split('=')[1]
    : '/';

  const userForgetPassword = useSelector((state) => state.userForgetPassword);
  const { userInfo, loading, error } = userForgetPassword;

  const dispatch = useDispatch();
  const submitHandler = (e) => {
    e.preventDefault();
      dispatch(forgetPassword(mobileNumber,password));
  };
  useEffect(() => {
    if (userInfo) {
      props.history.push(redirect);
    }
  }, [props.history, redirect, userInfo]);
  return (
    <div>
      <form className="form" onSubmit={submitHandler}>
        <div>
          <h1>Forget Password</h1>
        </div>
        {loading && <LoadingBox></LoadingBox>}
        {error && <MessageBox variant="danger">{error}</MessageBox>}
        <div>
          <label htmlFor="mobileNumber">Enter mobile number for Security check</label>
          <input
            type="tel"
            id="mobileNumber"
            placeholder="Enter Mobile Number"
            required
            onChange={(e) => setMobileNumber(e.target.value)}
          ></input>
        </div>

        <div>
          <label htmlFor="password">New Password</label>
          <input
            type="password"
            id="password"
            placeholder="Enter New password"
            required
            onChange={(e) => setPassword(e.target.value)}
          ></input>
        </div>

        <div>
          <label />
          <button className="primary" type="submit">
            Submit
          </button>
        </div>
      </form>
    </div>
  );
}