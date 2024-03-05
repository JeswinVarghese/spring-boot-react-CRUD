import {BrowserRouter, Routes, Route} from 'react-router-dom'
import './App.css'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import HeaderComponent from './components/HeaderComponent'
import FooterComponent from './components/FooterComponent'
import EmployeeComponent from './components/EmployeeComponent'

function App() {
  return (
    <div className='outer'>
      <BrowserRouter>
          <HeaderComponent/>
          <div className='content'>
          <Routes>
            <Route path='/' element = {<ListEmployeeComponent/>}></Route>
            <Route path='/getEmployeeDetails' element = {<ListEmployeeComponent/>}></Route>
            <Route path='/addEmployee' element = {<EmployeeComponent/>}></Route>
            <Route path='/updateEmployee/:id' element = {<EmployeeComponent/>}></Route>
          </Routes>
          </div>
          <div className='footer'>
              <footer></footer>
          </div>
      </BrowserRouter>
    </div>
  )
}

export default App
