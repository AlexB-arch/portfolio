import SearchBox from "./SearchBox";

export default function Navbar() {
	return (
		<nav id="Navbar" className="shadow-sm sticky top-0 left-0 z-50 bg-slate-600">
            <div className="h-[80px] w-full flex justify-between items-center max-w-7xl px-3 mx-auto">
                <p className="flex items-center justify-center gap-2">
                    <h1 className="text-2xl font-bold text-black">My Portfolio</h1>
                    <a href="#Home">Home</a>
                    <a href="#About">About</a>
                    <a href="#Projects">Projects</a>
                    <a href="#Contact">Contact</a>
                </p>

                <section className="flex items-center gap-3">
                    <div>
                        <SearchBox />
                    </div>
                </section>
            </div>
		</nav>
	);
}