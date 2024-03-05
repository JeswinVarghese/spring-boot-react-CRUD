import React, { useEffect, useState } from 'react'
import { listOfEmployees,deleteEmp } from '../services/EmployeeService'
import { useNavigate } from 'react-router-dom'

const ListEmployeeComponent = () => {

const [employees, setEmployees] = useState([])
const navigator = useNavigate();

  useEffect(()=>{
    getAllEmployees();
  }, [])

  function getAllEmployees(){
    listOfEmployees().then((response) => {
        setEmployees(response.data);
    }).catch(error=>{
        console.error(error);
    })
  }
  function addNewEmployee(){
        navigator('/addEmployee')
  }

  function updateEmployee(id){
        navigator(`/updateEmployee/${id}`)
  }

  function deleteEmployee(id){
        deleteEmp(id).then((response)=>{
            console.log(response.data);
            getAllEmployees();
        }).catch(error=>{
            console.error(error)
        })
  }

  return (
    <div className='container'>
        <h2 className='text-center'>List of Employees</h2>
        <button className='btn btn-primary' onClick={addNewEmployee}>Add Employee</button>
        <br/> <br/>
        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                    <th>Employee Id</th>
                    <th>Employee First Name</th>
                    <th>Employee Last Name</th>
                    <th>Employee Email</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                {
                    employees.map(employee => 
                        <tr>
                            <td>{employee.id}</td>
                            <td>{employee.firstName}</td>
                            <td>{employee.lastName}</td>
                            <td>{employee.email}</td>
                            <td><button className='btn btn-primary me-3' onClick={()=>updateEmployee(employee.id)}>Update</button>
                                <button className='btn btn-danger' onClick={()=>deleteEmployee(employee.id)}>Delete</button>
                            </td>
                        </tr>
                        )
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListEmployeeComponent