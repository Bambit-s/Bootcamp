import "./Header.css";

interface HeadData {
    head: string;
    data: string[];
    way: string[];
}

const datas: HeadData[] = [
    { head: "Logo", data: ["Products", "Resourses", "About us", "Contact Us"], way: ["/", "/", "/", "/"] }
];

function Header() {
    return (
        <header>
            <div>
                <a href="/">
                    <h1>{datas[0].head}</h1>
                </a>
                <nav>
                    <ul>
                        {datas[0].data.map((item, i) => (
                            <li key={i}>
                                <a href={datas[0].way[i]}>{item}</a>
                            </li>
                        ))}
                    </ul>
                </nav>
            </div>
            <div>
                <a href="/">Login</a>
                <a href="/">Look a Demo</a>
            </div>
        </header>
    )
}

export default Header