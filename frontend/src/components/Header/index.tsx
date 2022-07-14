import logo from '../../assets/img/logo.svg';

import "./style.css";

function Header() {
  return (
    <header>
      <div className="dsmeta-logo-container">
        <img src={logo} alt="DSMeta" />
        <h1>DSMeta</h1>
        <p>
          Desenvolvido por:
          <a href="https://www.linkedin.com/in/antonio-carlos-da-silva-moreira-7ab766189/">
            Carlos Moreira
          </a>
        </p>
      </div>
    </header>
  );
}

export default Header;
