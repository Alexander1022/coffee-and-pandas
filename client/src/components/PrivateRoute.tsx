import React, { PropsWithChildren, useEffect, useState } from 'react';
import { Navigate, Outlet, Routes } from 'react-router-dom';

export const PrivateRoute = ({ children }: any) => {
    const [isAuthenticated, setIsAuthenticated] = useState(true);

    const checkAuth = () => {
        const token = localStorage.getItem('userID');
        if (!token) {
            console.log(token);
            setIsAuthenticated(false);
        }
    }

    useEffect(() => {
        checkAuth();
    }, [isAuthenticated]);

    if (!isAuthenticated) {
        return <Navigate to={"/signin"} replace />;
    }

    return children ? children : <Outlet />;
};