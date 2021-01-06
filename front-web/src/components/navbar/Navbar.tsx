import './styles.css'
import { ReactComponent as Logo} from "./logo.svg";
import { Link } from 'react-router-dom';

function Navbar() {
    return (
        <nav className="navbar">
            <Logo/>
            <Link to="/" className="logo">Delivery</Link>
        </nav>
    );
}

export default Navbar;