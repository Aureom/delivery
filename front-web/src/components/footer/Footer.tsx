import './styles.css'
import { ReactComponent as InstagramSVG} from "./Instagram.svg";
import { ReactComponent as LinkedinSVG} from "./Linkedin.svg";
import { ReactComponent as YoutubeSVG} from "./Youtube.svg";

function Footer() {
    return (
        <footer className="main-footer">
            App desenvolvido durante a 2ª ed. do evento Semana DevSuperior
            <div className="footer-icons">
                <a href="https://www.google.com" target="_blank">
                    <InstagramSVG/>
                </a>
                <a href="https://www.google.com" target="_blank">
                    <LinkedinSVG/>
                </a>
                <a href="https://www.google.com" target="_blank">
                    <InstagramSVG/>
                </a>

            </div>
        </footer>
    );
}

export default Footer;