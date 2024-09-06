import Head from 'next/head'
import Image from 'next/image'
import { Inter } from 'next/font/google'
import styles from '@/styles/Home.module.css'
import PrimaryButtonEnabled from '@/components/button-primary-enabled'

const inter = Inter({ subsets: ['latin'] })

export default function Home() {
  return (

    <PrimaryButtonEnabled/>
  )
}
