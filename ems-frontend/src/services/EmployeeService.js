import axios from "axios";


const REST_API_URL = 'http://localhost:8080/api/employees';

export const listOfEmployees = () =>  axios.get(REST_API_URL+'/getAllEmployees');

export const createEmployee = (employee) => axios.post(REST_API_URL+'/addEmployee', employee);

export const getEmployee = (id) => axios.get(REST_API_URL+`/getEmployee/${id}`);

export const updateEmployee = (id,employee) => axios.put(REST_API_URL+`/updateEmployee?id=${id}`,employee);

export const deleteEmp = (id) => axios.delete(REST_API_URL+`/deleteEmployee/${id}`);
