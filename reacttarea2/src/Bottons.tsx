import './Botton.css'

interface BottonsStyle {
    botton: string[];
    style: string[];
};

const datas: BottonsStyle[] = [
    {
        style: ["botton1", "botton2", "botton3", "botton4", "botton5", "botton6"],
        botton: ["Label", "+Label", "Label+"]
    }

];

function Botton() {
    return (
        <div className="styles-container">
            {datas.map((data, dataIndex) => (
                <div key={dataIndex} className="style-group">
                    {data.style.map((styleClass, styleIndex) => (
                        <div key={styleIndex} className="style-variation">
                            <div className="buttons-container">
                                {data.botton.map((buttonText, buttonIndex) => (
                                    <button
                                        key={buttonIndex}
                                        className={`${styleClass} ${styleClass === 'botton3' || styleClass === 'botton6' ? 'disabled' : ''}`}
                                        disabled={styleClass === 'botton3' || styleClass === 'botton6'}
                                    >
                                        {buttonText}
                                    </button>
                                ))}
                            </div>
                        </div>
                    ))}
                </div>
            ))}
        </div>
    );
};

export default Botton;